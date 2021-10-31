using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using WebApplication.Models;

namespace WebApplication.Data
{
    interface IJobListingData
    {
        Task Create(JobListing jobListing);
        Task<IList<JobListing>> GetJobListings();

        JobListing Get(int id);
    }
}
